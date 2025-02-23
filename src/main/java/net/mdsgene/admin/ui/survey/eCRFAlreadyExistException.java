package net.mdsgene.admin.ui.survey;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "eCRF already exists.")
public class eCRFAlreadyExistException extends RuntimeException{
}
