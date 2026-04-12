package com.ruoyi.pet.mapper;

import java.util.List;
import com.ruoyi.pet.domain.PetImage;

public interface PetImageMapper 
{
    public PetImage selectPetImageByImageId(Long imageId);

    public List<PetImage> selectPetImageList(PetImage petImage);

    public List<PetImage> selectPetImagesByPetId(Long petId);

    public int insertPetImage(PetImage petImage);

    public int updatePetImage(PetImage petImage);

    public int deletePetImageByImageId(Long imageId);

    public int deletePetImageByImageIds(Long[] imageIds);

    public int deletePetImagesByPetId(Long petId);
}
