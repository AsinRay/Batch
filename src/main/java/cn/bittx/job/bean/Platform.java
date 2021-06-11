package cn.bittx.job.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Platform {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    // Pg 的自增需要设置seq,详细请参考resource/seq.sql
    @SequenceGenerator(name = "platform_id_seq", sequenceName = "platform_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platform_id_seq")
    private Integer id;
    private String version;
}
