package service;

import pojo.DataResult;

public interface ParkuseService {
    //分页
    DataResult limit(String currentPage, String pageSize);
}
