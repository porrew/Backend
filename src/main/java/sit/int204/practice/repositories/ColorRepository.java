package sit.int204.practice.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import sit.int204.practice.models.Color;

public interface ColorRepository extends JpaRepository <Color, Long>{

}
