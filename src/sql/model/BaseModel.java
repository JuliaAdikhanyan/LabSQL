package sql.model;

import java.util.Objects;

// класс базовой модели SQL
public class BaseModel {

    //ID товара
    protected int id;

    // метод equals
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseModel tempBaseModel = (BaseModel) o;
        return id == tempBaseModel.id;
    }

    // метод hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
