package com.javaeefinal.itse1908r.javaeefinal.Services;

import com.javaeefinal.itse1908r.javaeefinal.Models.BuildingsCategory;
import com.javaeefinal.itse1908r.javaeefinal.Repositories.BuildingsCategoryRepository;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
@RunWith(JUnit4.class)
public class BuildingCategoryService {

    @Inject
    BuildingsCategoryRepository buildingsCategoryRepository;

    public List<BuildingsCategory> getAllBuildingCategory() {return buildingsCategoryRepository.findAll();}

    public BuildingsCategory getBuildingCategoryById(Long id) {return buildingsCategoryRepository.findById(id);}

    public BuildingsCategory deleteBuildingCategoryById(int id) {return buildingsCategoryRepository.deleteById(id);}
}
