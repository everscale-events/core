package org.apache.flink.java;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.flink.util.Collector;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.io.IOException;

import static org.apache.flink.api.java.typeutils.TypeExtractor.getForClass;

/**
 * QueueProviderDeserializationSchema
 */
public class QueueProviderDeserializationSchema implements KafkaRecordDeserializationSchema<QueueProviderEvent> {
    @Override
    public void deserialize(ConsumerRecord<byte[], byte[]> record, Collector<QueueProviderEvent> out) throws IOException {
        String idempotencyKey = new String(record.key());
        String raw = new String(record.value());
        String[] fields = raw.split(" ");
        QueueProviderEvent event = new QueueProviderEvent(idempotencyKey, fields[0], fields[1], fields[2], record.timestamp());

        out.collect(event);
    }

    @Override
    public TypeInformation<QueueProviderEvent> getProducedType() {
        return getForClass(QueueProviderEvent.class);
    }
}

