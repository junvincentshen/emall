package com.jun.emall.tiny.dao;

import com.jun.emall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义Dao
 * Created by Vincent Shen on 2019/12/27.
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
