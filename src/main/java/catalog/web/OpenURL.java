package catalog.web;

import com.codeborne.selenide.Selenide;


public class OpenURL {
    private final static String token_admin = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2OTE0MDA3MjIsImV4cCI6MTcyMjUwNDcyMiwicm9sZXMiOltdLCJ1c2VybmFtZSI6ImxlbmEifQ.cZNdA731yvb0r9IbMF-KqC6H19uSGnkivVRablYqf-Y8BQySDm-qb_qUT6Igv4yntDZCMTTwQOG_jpdeN7Sy3fRsP97lE174MLwpVO0K9fhTAZ6PW_PghPGPVwwAvA7kwK87PFKy4cxeLQMvzEHXVQPMXQ3AZ20cPtouP7Q_3RweXuVRvBSyy3FYwOrl-i69jjX_EuXPus3UiluBeIgK_Fq5D1BoSKXSmMfZxL84aggGVJvC6TquCJ94XLNCnipCM_Gt62WlZ19bMKFTnb_LqbxEby4WgCKaPvfLJ1X1dMcFGQpI83BRn03SIgB6K5fHfckfCEWuNex4x7jDp3cSSw";


    public OpenURL(String url) {
        Selenide.open(url);
        Selenide.localStorage().setItem("token", token_admin);
        };


}
