package ch.zli.m223.ksh21a.mw.springintro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Role already exists")
public class RoleAlreadyExistsException extends RuntimeException {}
