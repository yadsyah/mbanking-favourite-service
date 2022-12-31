package id.co.diansetiyadi.favouriteservice.repository;

import id.co.diansetiyadi.favouriteservice.entity.Favourite;
import id.co.diansetiyadi.favouriteservice.util.CategoryFavouriteEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, String> {

    @Query("SELECT favourite FROM Favourite favorite WHERE favourite.cif=:cif AND favourite.categoryFavouriteEnum=:categoryFavouriteEnum AND favourite.sourceOfFundAccount=:sourceOfFundAccount")
    Optional<Favourite> findByCifAndCategoryAndSourceOfAccountNo(String cif, CategoryFavouriteEnum categoryFavouriteEnum, String sourceOfFundAccount);

    @Query("SELECT favourite FROM Favourite WHERE favourite.cif=:cif AND favourite.categoryFavouriteEnum=:categoryFavouriteEnum")
    List<Favourite> findByCifAndCategory(String cif, CategoryFavouriteEnum categoryFavouriteEnum);
    boolean existFindByCifAndCategoryAndSourceOfAccountNo(String cif, CategoryFavouriteEnum categoryFavouriteEnum, String sourceOfFundAccount);
}
