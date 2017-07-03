package com.yzh9954.spring.boot.dubbo.provider.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.duolabao.customer.shared.api.model.CityModel;
import com.duolabao.customer.shared.api.model.DistrictModel;
import com.duolabao.customer.shared.api.model.ProvinceModel;
import com.duolabao.customer.shared.api.service.AreaQueryService;

/**
 * Hello world!
 */
@Component
@Service(version = "1.0")
public class AreaQueryServiceImpl implements AreaQueryService {

    private static final Logger logger = LoggerFactory.getLogger(AreaQueryServiceImpl.class);

    /*
     * (non-Javadoc)
     * @see com.duolabao.customer.shared.api.service.AreaQueryService#listAllProvince()
     */
    @Override
    public List<ProvinceModel> listAllProvince() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.duolabao.customer.shared.api.service.AreaQueryService#listCityByProvinceCode(java.lang.String)
     */
    @Override
    public List<CityModel> listCityByProvinceCode(String provinceCode) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.duolabao.customer.shared.api.service.AreaQueryService#getProvinceCodeByProvinceName(java.lang.String)
     */
    @Override
    public String getProvinceCodeByProvinceName(String provinceName) {
        // TODO Auto-generated method stub
        logger.info("the arguments is-=---" + provinceName);
        return provinceName;
    }

    /*
     * (non-Javadoc)
     * @see com.duolabao.customer.shared.api.service.AreaQueryService#getCityCodeByCityName(java.lang.String)
     */
    @Override
    public String getCityCodeByCityName(String cityName) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.duolabao.customer.shared.api.service.AreaQueryService#listCityByProvince(java.lang.String)
     */
    @Override
    public List<CityModel> listCityByProvince(String province) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.duolabao.customer.shared.api.service.AreaQueryService#listDistrictByCityCode(java.lang.String)
     */
    @Override
    public List<DistrictModel> listDistrictByCityCode(String cityCode) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.duolabao.customer.shared.api.service.AreaQueryService#listDistrictByCity(java.lang.String)
     */
    @Override
    public List<DistrictModel> listDistrictByCity(String city) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.duolabao.customer.shared.api.service.AreaQueryService#queryDistrictCodeByName(java.lang.String)
     */
    @Override
    public String queryDistrictCodeByName(String arg0) {
        // TODO Auto-generated method stub
        return null;
    }
}
