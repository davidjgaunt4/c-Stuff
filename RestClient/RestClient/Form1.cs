using Newtonsoft.Json;
using RestClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RestClient
{
    public partial class RestClient : Form
    {
        public RestClient()
        {
            InitializeComponent();
        }

        private void cmdSubmit_Click(object sender, EventArgs e)
        {
            restClient rClient = new restClient();
            rClient.endPoint = txtRequest.Text;

            DebugText("restClient Created");

            string response = string.Empty;
            response = rClient.makeRequest();

            


           deserialiseJSON(response);

        }
        private void DebugText(string text)
        {
            System.Diagnostics.Debug.Write(text);
            txtResponse.Text = txtResponse.Text + text + Environment.NewLine;
            txtResponse.SelectionStart = txtResponse.SelectionLength;
            txtResponse.ScrollToCaret();
        }

        private void deserialiseJSON(string json)
        {
            var jsonresponse = JsonConvert.DeserializeObject<jsonArray>(json);
            DebugText(jsonresponse.ToString());

        }
    }
}
