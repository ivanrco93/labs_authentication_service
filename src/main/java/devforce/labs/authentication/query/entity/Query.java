package devforce.labs.authentication.query.entity;

public class Query {
    String name;
    String field;
    String type;
    WhereType whereType;
    String description;
    String start;
    String end;
    String value;
    String comparison;

    public Query(){};

    public Query(String name, String field, String type, WhereType whereType, String description, String start, String end, String value, String comparison) {
        this.name = name;
        this.field = field;
        this.type = type;
        this.whereType = whereType;
        this.description = description;
        this.start = start;
        this.end = end;
        this.value = value;
        this.comparison = comparison;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WhereType getWhereType() {
        return whereType;
    }

    public void setWhereType(WhereType whereType) {
        this.whereType = whereType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComparison() {
        return comparison;
    }

    public void setComparison(String comparison) {
        this.comparison = comparison;
    }
}
