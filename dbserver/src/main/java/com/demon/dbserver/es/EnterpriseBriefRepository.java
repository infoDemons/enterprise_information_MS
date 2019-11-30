package com.demon.dbserver.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EnterpriseBriefRepository extends ElasticsearchRepository<EnterpriseBrief, Integer> {

    List<EnterpriseBrief> findByEnterpriseNameIsContaining(String enterpriseName);

    List<EnterpriseBrief> findByEnterpriseNameLike(String enterpriseName);
}
