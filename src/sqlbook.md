## SQL Openbook

### MYSQL 계층형 쿼리
```java
WITH RECURSIVE T AS(
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR+1 FROM T
    WHERE HOUR<23
)
```

