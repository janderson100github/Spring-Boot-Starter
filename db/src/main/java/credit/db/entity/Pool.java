package credit.db.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pool")
public class Pool implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date created;

    @Column(nullable = false)
    private String prefix;

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long total;

    @Column(name = "des",
            columnDefinition = "TEXT")
    private String description;

    public Pool() {
        this.created = new Date();
    }

    public Pool(final String prefix, final Long id, final Long total, final String description) {
        super();
        this.id = id;
        this.prefix = prefix;
        this.total = total;
        this.description = description;
    }

    public Long getGid() {
        return gid;
    }

    public Date getCreated() {
        return created;
    }

    public Long getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDescription() {
        return description;
    }

    public Long getTotal() {
        return total;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Pool{" + "gid=" + gid + ", created=" + created + ", id=" + id + ", prefix='" + prefix + '\'' + '}';
    }
}
