# JedisExample

Just an example for using Jedis, allowing to post articles to a database and rate them afterwards.

All done within the scope of my study.

Basic features covered:
- Usage of different structures, like Sets, Hashs, SortedSets


Output of Main.java:
```
log4j:WARN No appenders could be found for logger (de.db.praktikum4.RedisDBImpl).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
45 [main] INFO de.db.praktikum4.Main  - Posting several articles
925 [main] INFO de.db.praktikum4.Main  - Retrieving articles:
967 [main] INFO de.db.praktikum4.Main  - ArticleInfo [author=Ethernet, title=Metcalfe/Bloggs]
967 [main] INFO de.db.praktikum4.Main  - ArticleInfo [author=Chen, title=The Entity Relationship Model]
968 [main] INFO de.db.praktikum4.Main  - ArticleInfo [author=Go To Statement Considered Harmful, title=Dijkstra]
968 [main] INFO de.db.praktikum4.Main  - ArticleInfo [author=Ritchie/Thompson, title=UNIX Time Sharing System]
968 [main] INFO de.db.praktikum4.Main  - ArticleInfo [author=OSI Reference Model, title=Zimmerman]
968 [main] INFO de.db.praktikum4.Main  - ArticleInfo [author=A Relational Model of Datafor Large Shared Data Banks, title=Codd]
969 [main] INFO de.db.praktikum4.Main  - ArticleInfo [author=Hoare, title=Communicating Sequential Processes]
969 [main] INFO de.db.praktikum4.Main  - ArticleInfo [author=New Directions in Cryptography, title=Diffie/Hellman]
969 [main] INFO de.db.praktikum4.Main  - Rating articles:
972 [main] INFO de.db.praktikum4.Main  - Rater1 rates Ethernet with 1.2. In Total 1.2
972 [main] INFO de.db.praktikum4.Main  - Rater1 rates Ethernet a second time with 2.0. Duplicate detection: -1.0
973 [main] INFO de.db.praktikum4.Main  - Rater2 rates Ethernet with 3.5. In Total 2.35
974 [main] INFO de.db.praktikum4.Main  - Rater3 rates Ethernet with 2.6. In Total 2.4333333333333336
975 [main] INFO de.db.praktikum4.Main  - Rater1 rates CRYPTO with 2.0. In Total 2.0
976 [main] INFO de.db.praktikum4.Main  - Rater2 rates CRYPTO with 3.5. In Total 2.75
977 [main] INFO de.db.praktikum4.Main  - Rater3 rates CRYPTO with 2.6. In Total 2.6999999999999997
978 [main] INFO de.db.praktikum4.Main  - Rater1 rates CSP with 3.0. In Total 3.0
979 [main] INFO de.db.praktikum4.Main  - Rater2 rates CSP with 4.5. In Total 3.75
980 [main] INFO de.db.praktikum4.Main  - Rater3 rates CSP with 3.6. In Total 3.6999999999999997
980 [main] INFO de.db.praktikum4.Main  - Get the n-best articles:
1065 [main] INFO de.db.praktikum4.Main  - N = 1: 
[ArticleInfo [author=Ethernet, title=Metcalfe/Bloggs]]
1066 [main] INFO de.db.praktikum4.Main  - N = 2: 
[ArticleInfo [author=Ethernet, title=Metcalfe/Bloggs], ArticleInfo [author=New Directions in Cryptography, title=Diffie/Hellman]]
1067 [main] INFO de.db.praktikum4.Main  - N = 3: 
[ArticleInfo [author=Ethernet, title=Metcalfe/Bloggs], ArticleInfo [author=New Directions in Cryptography, title=Diffie/Hellman], ArticleInfo [author=Hoare, title=Communicating Sequential Processes]]
1068 [main] INFO de.db.praktikum4.Main  - N = 4 (only 3 articles in total are rated): 
[ArticleInfo [author=Ethernet, title=Metcalfe/Bloggs], ArticleInfo [author=New Directions in Cryptography, title=Diffie/Hellman], ArticleInfo [author=Hoare, title=Communicating Sequential Processes]]
1068 [main] INFO de.db.praktikum4.Main  - Continue rating articles:
1069 [main] INFO de.db.praktikum4.Main  - Rater4 rates CRYPTO with 1.0. In Total 2.275
1069 [main] INFO de.db.praktikum4.Main  - Get the n-best articles again. Now CRYPTO should be at first place:
1070 [main] INFO de.db.praktikum4.Main  - N = 1: 
[ArticleInfo [author=New Directions in Cryptography, title=Diffie/Hellman]]
1070 [main] INFO de.db.praktikum4.Main  - N = 2: 
[ArticleInfo [author=New Directions in Cryptography, title=Diffie/Hellman], ArticleInfo [author=Ethernet, title=Metcalfe/Bloggs]]
1071 [main] INFO de.db.praktikum4.Main  - N = 3: 
[ArticleInfo [author=New Directions in Cryptography, title=Diffie/Hellman], ArticleInfo [author=Ethernet, title=Metcalfe/Bloggs], ArticleInfo [author=Hoare, title=Communicating Sequential Processes]]
1072 [main] INFO de.db.praktikum4.Main  - N = 4 (only 3 articles in total are rated): 
[ArticleInfo [author=New Directions in Cryptography, title=Diffie/Hellman], ArticleInfo [author=Ethernet, title=Metcalfe/Bloggs], ArticleInfo [author=Hoare, title=Communicating Sequential Processes]]

```
