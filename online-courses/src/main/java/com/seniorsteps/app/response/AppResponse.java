package com.seniorsteps.app.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.seniorsteps.app.models.eums.ResponseCode;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppResponse<D> {
	
	private D data;
	private ResponseError error;
	private Map<String, String> metaInfo = new HashMap<>();
	
	@JsonIgnore
	private HttpStatus httpStatus;
	
	public AppResponse(Map<String, String> metaInfo, D data, ResponseError error, HttpStatus httpStatus) {
		this.data = data;
		this.metaInfo = metaInfo;
		this.httpStatus = httpStatus;
		this.error = error;
	}
	
	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

	public ResponseError getError() {
		return error;
	}

	public void setError(ResponseError error) {
		this.error = error;
	}

	public Map<String, String> getMetaInfo() {
		return metaInfo;
	}

	public void setMetaInfo(Map<String, String> metaInfo) {
		this.metaInfo = metaInfo;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	@JsonIgnore
	public ResponseEntity<AppResponse<D>> getResponseEntity() {
		return new ResponseEntity<AppResponse<D>>(this, this.getHttpStatus());
	}
	
	
	public static<D> ResponseBuilder<D> builder() {
		return new ResponseBuilder<>();
	}
	
	public static class ResponseBuilder<D> {
		
		private Map<String, String> info = new HashMap<>();
		private ResponseCode responseCode = ResponseCode.SUCCESS;
		
		private D data;
		
		
		public ResponseBuilder<D> info(String key, String value) {
			if(key != null && value != null)
				info.put(key, value);
			return this;
		}
		
		public ResponseBuilder<D> data(D data) {
			if(data != null) 
				this.data = data;
			else 
				this.responseCode = ResponseCode.NOT_FOUND;
			return this;
		}
		
		public ResponseBuilder<D> status(ResponseCode responseCode) {
			if(responseCode != null && responseCode != ResponseCode.SUCCESS)
				this.responseCode = responseCode;
			return this;
		}
		
		public AppResponse<D> build() {
			
			ResponseError error = null;
			
			if(responseCode.getHttpStatus() != HttpStatus.OK)
				error = new ResponseError(responseCode);
			
            return new AppResponse<D>(info, data, error, responseCode.getHttpStatus());
        }
		
    }

	
	
	
	
}
