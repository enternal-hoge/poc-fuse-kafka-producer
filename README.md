# poc-fuse-kafka-producer
学習用

# FuseからKafkaへの連携シナリオ


## 実行方法

zookeeperを起動する。

```
cd <HOME>/mylabs/kafka_2.12-2.4.0.redhat-00005
bin/zookeeper-server-start.sh config/zookeeper.properties &
```


kafkaを起動する。

```
bin/kafka-server-start.sh config/server.properties &
```

Itemトピックを作成する。※起動毎に一度のみ。
```
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic item-topic
```

作成したItemトピックを確認する。

```
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
item-topic
```

当モジュールで送信したファイルの内容を確認したい場合
```
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic item-topic --from-beginning
```

### スタンドアロンの起動方法

	mvn spring-boot:run


## アプリケーションの実行

data/inputフォルダ配下に以下のファイル名でファイルを配備して下さい。

message.csv

ファイルの内容は以下の通りです。
```
"name", "amount", "customer"
"brake pad", "2", "ktm"
```

同一ファイル名のファイルをdata/inputに多いても、動かないのでmessage1.csvとかリネームして配備する。

以上
