package uk.gov.hmcts.reform.authorisation;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@FeignClient(name = "idam-s2s-auth", url = "${idam.s2s-auth.url}")
public interface ServiceAuthorisationApi {
    @PostMapping(value = "/lease")
<<<<<<< HEAD
    String serviceToken(@RequestBody Map<String, String> signIn,
                        @RequestHeader("Content-Type") String contentType);
=======
    @Headers("Content-Type: application/json")
    @Body("\"%7B\"microservice\":\"{microservice}\",\"one_time_password\":\"{oneTimePassword}\"%7D")
    String serviceToken(@RequestParam("microservice") final String microservice,
                        @RequestParam("oneTimePassword") final String oneTimePassword);
>>>>>>> update key in the request body

    @SuppressWarnings("PMD.UseVarargs")
    @GetMapping(value = "/authorisation-check")
    void authorise(@RequestHeader(AUTHORIZATION) final String authHeader,
                   @RequestParam("role") final String[] roles);

    @GetMapping(value = "/details")
    String getServiceName(@RequestHeader(AUTHORIZATION) final String authHeader);
}
