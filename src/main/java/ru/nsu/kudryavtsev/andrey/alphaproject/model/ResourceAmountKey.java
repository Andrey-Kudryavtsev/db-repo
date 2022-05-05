package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ResourceAmountKey implements Serializable {
    @Column(name = "recommended_service_id")
    @Getter @Setter
    private long recommendedServiceId;

    @Column(name = "resource_id")
    @Getter @Setter
    private long resourceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceAmountKey that = (ResourceAmountKey) o;
        return recommendedServiceId == that.recommendedServiceId && resourceId == that.resourceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recommendedServiceId, resourceId);
    }
}
