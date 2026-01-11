## Join in JPA
    - @JoinColumn : for 1 - 1 , N - 1 relationship 
    - @JoinTable : for N - N relationship 
    - @mappedBy : for main entity that has not `FK`
    - @Join is used for entity that has `FK`
    - @Column : to map 1 filed - 1 column 
---
## SQL Server Configuration
    - ### DDl-auto 
        - create : remove old table and create new table
        - update : automatically update schema
        - validate : only check entity java <---> table sql , data type , the number of colummn ...
    - ### Thymeleaf 
        - spring.thymeleaf.cache 
            - true : thymeleaf -> .html -> save memory -> change html -> f5 -> no any changes -> have to restart app 
            - false : only need f5 to see changes after editing html without restarting app 
    
    