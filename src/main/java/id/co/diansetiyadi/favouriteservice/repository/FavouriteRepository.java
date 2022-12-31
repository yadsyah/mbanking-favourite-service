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

    @Query("SELECT Favourite FROM Favourite WHERE cif=:cif AND categoryFavouriteEnum=:categoryFavouriteEnum AND sourceOfFundAccount=:sourceOfFundAccount")
    Optional<Favourite> findByCifAndCategoryAndSourceOfAccountNo(String cif, CategoryFavouriteEnum categoryFavouriteEnum, String sourceOfFundAccount);

    @Query("SELECT Favourite FROM Favourite WHERE cif=:cif AND categoryFavouriteEnum=:categoryFavouriteEnum")
    List<Favourite> findByCifAndCategory(String cif, CategoryFavouriteEnum categoryFavouriteEnum);
}
