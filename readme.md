# API REST to check if a given CEP is in the same range of another

### Examples

| First CEP | Second CEP |
| --------- | ---------- |
| 10000000  | 20000000   |
| 20000001  | 30000000   |

Given CEP above are not in the same range.

| First CEP | Second CEP |
| --------- | ---------- |
| 10000000  | 20000000   |
| 20000000  | 30000000   |

Above given CEP are in the same range due to duplicated "*20000000*"

How it should work

![](https://github.com/tfalc/CepApi/blob/main/src/main/resources/img/UMLCase.png)

## Tecnologies used:

- Java
- Spring Web
- Jpa
- Lombok
- PostgreSQL