package de.rboerner.springdemo.jms;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MyAppEvent implements Serializable {

    private static final long serialVersionUID = -6787872614494015901L;

    private String message;

    private Integer priority;

}
