package devforce.labs.authentication.query.matcher;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.query.entity.Query;

import java.util.List;

public interface CustomizedExampleMatcher<T> {
    List<Object> findAllByFilters(List<Query> query, Class<T> entityClass);
}
