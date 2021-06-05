package service;

import pojo.DataResult;

public interface CarService {
    DataResult limit(String currentPage, String pageSize);
}
