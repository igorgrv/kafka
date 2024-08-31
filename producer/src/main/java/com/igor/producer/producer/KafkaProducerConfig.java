package com.igor.producer.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {

  @Value("${topics.payment.request.topic}")
  private String pagamentoRequestTopic;

  private final ProducerFactory<String, String> producerFactory;

  public KafkaProducerConfig(ProducerFactory<String, String> producerFactory) {
    this.producerFactory = producerFactory;
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate() {
      return new KafkaTemplate<>(producerFactory);
  }

  // @Bean
  // public ProducerFactory<String, String> producerFactory() {
  // Map<String, Object> configProps = new HashMap<>();
  // configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
  // "https://k3xmz85dxb33p0wy.svc02.us-south.eventstreams.cloud.ibm.com");
  // configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
  // StringSerializer.class);
  // configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
  // JsonSerializer.class);

  // // Configurações de autenticação SASL/SSL
  // configProps.put("security.protocol", "SASL_SSL");
  // configProps.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
  // configProps.put(SaslConfigs.SASL_JAAS_CONFIG,
  // "org.apache.kafka.common.security.plain.PlainLoginModule required
  // username='dmQb-U6Ni37IWdgeTgSRv2pU-3A_TDJzPCywItxSmnf2'
  // password='dmQb-U6Ni37IWdgeTgSRv2pU-3A_TDJzPCywItxSmnf2';");

  // // Configuração da API Key (se necessário)
  // // configProps.put("sasl.login.callback.handler.class",
  // //
  // "org.apache.kafka.common.security.authenticator.AbstractLogin$DefaultLoginCallbackHandler");
  // // configProps.put("sasl.jaas.config",
  // // "org.apache.kafka.common.security.plain.PlainLoginModule required
  // username='your-apikey' password='your-password';");

  // return new DefaultKafkaProducerFactory<>(configProps);
  // }

  // @Bean
  // public KafkaTemplate<String, String> kafkaTemplate() {
  //   return new KafkaTemplate<>(producerFactory());
  // }

  @Bean
  public NewTopic pagamentoRequestTopicBuilder() {
    return TopicBuilder
        .name(pagamentoRequestTopic)
        .partitions(1)
        .replicas(1)
        .build();
  }

}
