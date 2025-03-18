package property;

import java.util.Objects;

public abstract class AbstractProperty implements Property{
    protected double worth;

    public AbstractProperty(double worth) {
        this.worth = worth;
    }

    @Override
    public double getWorth() {
        return worth;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractProperty property = (AbstractProperty) obj;
        return Double.compare(property.worth, worth) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(worth);
    }
}
