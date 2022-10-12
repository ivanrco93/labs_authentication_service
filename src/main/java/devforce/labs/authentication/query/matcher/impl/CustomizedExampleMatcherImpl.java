package devforce.labs.authentication.query.matcher.impl;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.query.entity.Query;
import devforce.labs.authentication.query.entity.WhereType;
import devforce.labs.authentication.query.matcher.CustomizedExampleMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomizedExampleMatcherImpl<T> implements CustomizedExampleMatcher<T> {
    @PersistenceContext
    EntityManager entityManager;

    private Class<T> entityClass;

    @Override
    public List<Object> findAllByFilters(List<Query> query, Class<T> entityClass) {
        this.entityClass = entityClass;
        System.out.println("Step 1");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        System.out.println("Step 2");
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(Object.class);
        System.out.println("Step 3");
        Root<T> itemRoot = criteriaQuery.from(this.entityClass);
        System.out.println("Step 4");
        List<Predicate> predicates = new ArrayList<>();

        System.out.println("Checking query");
        for(Query q: query){
            predicates.add(getPredicate(q, itemRoot, criteriaBuilder));
        }
        System.out.println("End checking query");

        Predicate finalPredicate
                = criteriaBuilder
                .or(
                        this.getPredicatesByWhereType(criteriaBuilder, query, predicates, WhereType.AND),
                        this.getPredicatesByWhereType(criteriaBuilder, query, predicates, WhereType.OR));

        //criteriaQuery.select(itemRoot).where(predicates.toArray(new Predicate[]{}));
        criteriaQuery.select(itemRoot).where(finalPredicate);


        /*criteriaQuery.select(itemRoot).where(criteriaBuilder.disjunction(predicates.get(0)));
        criteriaQuery.select(itemRoot).where(criteriaBuilder.or(predicates.get(1)));
        criteriaQuery.select(itemRoot).where(criteriaBuilder.or(predicates.get(2)));*/

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    String getType(String fieldName){
         Class<?> clazz = this.entityClass;
         clazz.getDeclaredFields();
         for(Field field : clazz.getDeclaredFields()) {
             //you can also use .toGenericString() instead of .getName(). This will
             //give you the type information as well.
             //System.out.println("checking field Name: ");
             //System.out.println(field.getName());
             //System.out.println(field.getType());
             if(field.getName().equals(fieldName)){
                 return field.getType().toString();
             }
         }
         return null;
    }
    Predicate getPredicatesByWhereType(CriteriaBuilder cb, List<Query> query, List<Predicate> predicateList, WhereType w){
        List<Predicate> predicates = new ArrayList<>();
        int i = 0;
        for(Predicate p: predicateList){
            if(query.get(i).getWhereType().equals(w)){
                predicates.add(p);
            }
            i++;
        }
        return cb.and(predicates.toArray(new Predicate[]{}));
    }
    Predicate getPredicate(Query q, Root<T> ir, CriteriaBuilder cb){
        Predicate p = null;
        switch (q.getType()){
            case "select":
            case "text":
            case "number":
            case "radio":
                if(this.getType(q.getField()).equals("boolean"))
                    p = cb.equal(ir.get(q.getField()), Boolean.parseBoolean(q.getValue()));
                else
                    p = cb.equal(ir.get(q.getField()), q.getValue());
                break;
            case "numbercomparison":
                p = getNumberComparisionPredicate(cb, ir, q);
                break;
            case "radionullcomparison":
                if(q.getValue()=="YES"){
                    p = cb.isNull(ir.get(q.getField()));
                }else{
                    p = cb.isNotNull(ir.get(q.getField()));
                }
                break;
            case "textlike":
                p = cb.like(ir.get(q.getField()), q.getValue());
                break;
            case "date":
                p = cb.between(ir.get(q.getField()), q.getStart(), q.getEnd());
                break;
            case "timestamp":
                p = cb.between(ir.get(q.getField()), q.getStart()+" 00:00:00", q.getEnd()+" 23:59:59");
                break;
        }

        return q.getWhereType().equals(WhereType.AND)?cb.and(p):cb.or(p);
    }

    Predicate getNumberComparisionPredicate(CriteriaBuilder cb, Root<T> ir, Query q){
        switch (q.getType()){
            case "EQUALS":
                return cb.equal(ir.get(q.getField()), q.getValue());
            case "DIFFERENT":
                return cb.notEqual(ir.get(q.getField()), q.getValue());
            case "GREATHER_THAN":
                return cb.greaterThan(ir.get(q.getField()), q.getValue());
            case "SMALLER_THAN":
                return cb.lessThan(ir.get(q.getField()), q.getValue());
            case "GREATHER_THAN_OR_EQUAL":
                return cb.greaterThanOrEqualTo(ir.get(q.getField()), q.getValue());
            case "SMALLER_THAN_OR_EQUAL":
                return cb.lessThanOrEqualTo(ir.get(q.getField()), q.getValue());
        }
        return null;
    }
}
