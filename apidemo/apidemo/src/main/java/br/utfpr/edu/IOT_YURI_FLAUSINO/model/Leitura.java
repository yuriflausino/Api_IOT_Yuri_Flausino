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

@Table(name = "tb_leitura")
@Data
public class Leitura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Sensor sensor;

    @Column(nullable = false)
    private Double valor;
    @Column(nullable = false)
    private String data;
}
