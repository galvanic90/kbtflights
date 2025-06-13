package com.udea.kbtflights.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name = "nombre_avion", nullable = false, length = 80)
    private String planeName;

    @NotNull
    @Column(name = "numero_vuelo", nullable = false, length = 80)
    private String numberFlight;

    @NotNull
    @Column(name = "origin", nullable = false, length = 80)
    private String origin;

    @NotNull
    @Column(name = "destino", nullable = false, length = 80)
    private String destination;

    @NotNull
    @Column(name = "capacidad", nullable = false, length = 80)
    private int capacity;

    @NotNull
    @Column(name = "rating", nullable = false, length = 80)
    @Min(value = 1, message = "rating should be at least 1")
    @Max(value = 5, message = "The rating shoud be less or equal to 5")
    private int rating;

    @NotNull
    @Column(name = "plan_vuelo", nullable = false, length = 80)
    private int planVuelo;

    private Boolean checked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public String getNumberFlight() {
        return numberFlight;
    }

    public void setNumberFlight(String numberFlight) {
        this.numberFlight = numberFlight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPlanVuelo() {
        return planVuelo;
    }

    public void setPlanVuelo(int planVuelo) {
        this.planVuelo = planVuelo;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
