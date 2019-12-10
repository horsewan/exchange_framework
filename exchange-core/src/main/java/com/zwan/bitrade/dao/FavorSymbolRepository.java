package com.zwan.bitrade.dao;

import com.zwan.bitrade.entity.FavorSymbol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavorSymbolRepository extends JpaRepository<FavorSymbol,Long>{
    FavorSymbol findByMemberIdAndSymbol(Long memberId,String symbol);
    List<FavorSymbol> findAllByMemberId(Long memberId);
}
