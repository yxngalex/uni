package ac.rs.metropolitan.it355dz06.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exams")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "picked", nullable = false, length = 10)
    private String picked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Exam exam = (Exam) o;
        return id != null && Objects.equals(id, exam.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}