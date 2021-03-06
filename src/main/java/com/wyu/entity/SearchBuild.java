package com.wyu.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class SearchBuild implements Serializable {

    private static final long serialVersionUID = -5720329775229249225L;
    private String[] indexes;
    private int page;
    private int size;
    private String[] includeFields;
    private String[] excludeFields;
    private Map<String, Boolean> sortFieldsToAsc;
    private Map<String, Object> where;


}
