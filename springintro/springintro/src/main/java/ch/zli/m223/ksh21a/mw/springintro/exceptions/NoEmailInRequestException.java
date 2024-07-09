package ch.zli.m223.ksh21a.mw.springintro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Email does not exist!")
public class NoEmailInRequestException extends RuntimeException {}
