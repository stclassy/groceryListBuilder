package com.groceryListBuilder.entity;

import javax.persistence.*;

/**
 * The type Meausurment units.
 */
@Entity(name = "MeasurmentUnits")
@Table(name = "measurment_units")
public class MeausurmentUnits {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @Column(name = "measurmentId")
    private int unitId;
    @Column(name = "description")
    private String unitName;

    /**
     * Instantiates a new Meausurment units.
     */
    public MeausurmentUnits() {
    }

    /**
     * Instantiates a new Meausurment units.
     *
     * @param unitName the unit name
     */
    public MeausurmentUnits(String unitName) {
        this.unitName = unitName;
    }

    /**
     * Gets unit id.
     *
     * @return the unit id
     */
    public int getUnitId() {
        return unitId;
    }

    /**
     * Sets unit id.
     *
     * @param unitId the unit id
     */
    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    /**
     * Gets unit name.
     *
     * @return the unit name
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * Sets unit name.
     *
     * @param unitName the unit name
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public String toString() {
        return "MeausurmentUnits{" +
                "unitId=" + unitId +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}
