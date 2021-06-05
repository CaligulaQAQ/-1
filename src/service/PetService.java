package service;

import pojo.DataResult;

public interface PetService {
    //分页
    DataResult limit(String currentPage, String pageSize);
}
