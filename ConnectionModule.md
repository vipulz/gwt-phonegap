# get connection information #

```
String type = phoneGap.getConnection().getType();
if(Connection.CELL_2G.equals(type)){
//we are on a 2g connection
}
```


# connection and dev mode #

by default the connection module always returns ETHERNET in dev mode. You can set a different value like this:
```
if(phoneGap.isDevMode()){
	((ConnectionMock)phoneGap.getConnection()).setType(Connection.CELL_2G);
}
```