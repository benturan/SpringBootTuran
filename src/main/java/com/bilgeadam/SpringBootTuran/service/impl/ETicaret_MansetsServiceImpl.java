package com.bilgeadam.SpringBootTuran.service.impl;
import java.util.List;

 
import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Manset;
import com.bilgeadam.SpringBootTuran.repository.ETicaret_MansetRepository;
import com.bilgeadam.SpringBootTuran.service.ETicaret_MansetService;
 


@Service
public class ETicaret_MansetsServiceImpl implements ETicaret_MansetService{
    @SuppressWarnings("unused")
	private final ETicaret_MansetRepository eTicaret_MansetRepository;
    
    
       public ETicaret_MansetsServiceImpl
       (ETicaret_MansetRepository eTicaret_MansetRepository ) {
           this.eTicaret_MansetRepository = eTicaret_MansetRepository;
           
       }

	
	@Override
	public List<ETicaret_Manset> getAll() {
		 List<ETicaret_Manset> data = eTicaret_MansetRepository.findAll();
	        return data;
	}

	@Override
	public ETicaret_Manset getById(Long id) {
		ETicaret_Manset p = eTicaret_MansetRepository.getOne(id);
        return p;
	}

	@Override
	public ETicaret_Manset save(ETicaret_Manset eTicaret_Manset) {
		ETicaret_Manset eTicaret_Mansetsdb = eTicaret_MansetRepository.save(eTicaret_Manset);
        return eTicaret_Mansetsdb;
	}

	@Override
	public ETicaret_Manset update(ETicaret_Manset eTicaret_Manset) {
		ETicaret_Manset mansetDb = eTicaret_MansetRepository.getOne(eTicaret_Manset.getId());
        if (mansetDb == null)
            throw new IllegalArgumentException("Manset Does Not Exist ID:" + eTicaret_Manset.getId());


      // projectDb.setProjectCode(eTicaret_Products.getProjectCode());
      // projectDb.setProjectName(eTicaret_Products.getProjectName());
      // projectDb.setInsertDate(project.);
        ETicaret_Manset mansetUpd = eTicaret_MansetRepository.save(mansetDb);
       return mansetUpd;
	}
	
	@Override
	public List<Object[]> allMansetdataProduct(int mansetid) {
		List<Object[]> data = eTicaret_MansetRepository.allMansetdataProduct(mansetid);
		return data;
	}


	@Override
	public ETicaret_Manset mansetById(int id) {
		ETicaret_Manset data = eTicaret_MansetRepository.mansetById(id);
		return data;
	}


	@Override
	public Boolean delete(Long id) {
		eTicaret_MansetRepository.deleteById(id);
        return true;
	}
	
	
	public List<ETicaret_Manset> getAllOrderBySira() {
		 List<ETicaret_Manset> data = eTicaret_MansetRepository.getAllMansetOrderBySira();
	        return data;
	}
	

}
