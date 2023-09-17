package com.allfather163.skypro.employeeBook;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Сотрудник не найден")
public class NotFoundException extends RuntimeException {
}