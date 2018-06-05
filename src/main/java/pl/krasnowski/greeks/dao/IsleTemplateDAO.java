package pl.krasnowski.greeks.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import pl.krasnowski.greeks.model.world.IsleTemplate;

@Transactional
public interface IsleTemplateDAO extends CrudRepository<IsleTemplate, Integer> {

}
