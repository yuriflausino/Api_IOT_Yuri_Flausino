package br.utfpr.edu.IOT_YURI_FLAUSINO.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity

@Table(name = "tb_sensor")
@Data
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Dispositivo dispositivo;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String tipo;
}
