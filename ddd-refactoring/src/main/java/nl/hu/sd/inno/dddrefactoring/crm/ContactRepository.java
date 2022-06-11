package nl.hu.sd.inno.dddrefactoring.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
