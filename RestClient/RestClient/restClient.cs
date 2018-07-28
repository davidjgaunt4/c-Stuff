using System;
using System.IO;
using System.Net;
namespace RestClient
{
    public enum httpVerb
    {
        GET,
        POST,
        DELETE,
        PUT
    }
    public class restClient
    {
        public string endPoint { get; set; }
        public httpVerb httpMethod { get; set; }
        public restClient()
        {
            endPoint = string.Empty;
            httpMethod = httpVerb.GET;
        }

        public string makeRequest() {
            string strResponse = string.Empty;

            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(endPoint);
            request.Method = httpMethod.ToString();


            using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
            {
                if (response.StatusCode != HttpStatusCode.OK)
                {
                    throw new ApplicationException("It's all gone to pot !!!!");
                }

                using (Stream responseStream = response.GetResponseStream())
                {
                    if (responseStream != null)
                    {
                        using (StreamReader responseReader = new StreamReader(responseStream))
                        {
                            strResponse = responseReader.ReadToEnd();
                        }//StreamReader
                    }
                  
                }//Stream REsponse
            }//httpWebResponse
            return strResponse;
        }

    }
}
