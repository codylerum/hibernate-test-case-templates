package org.hibernate.bugs;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class EventLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String message;

    @Id
    @GeneratedValue(generator = "eventLogIdGenerator")
    @GenericGenerator(name = "eventLogIdGenerator", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = { @Parameter(name = "table_name", value = "primaryKeyPools"),
            @Parameter(name = "segment_value", value = "eventLog"), @Parameter(name = "optimizer", value = "pooled"), @Parameter(name = "increment_size", value = "500"),
            @Parameter(name = "initial_value", value = "1") })
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
