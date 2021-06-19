using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Daryl_PL
{
    public partial class Contact : Page
    {
        localhost.Service1 myDatabaseAdapter = new localhost.Service1();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                String tmpUserRecID = Request.QueryString["userRecID"];

                if (tmpUserRecID != null) 
                {
                    DataRow tmpDataRow = null;
                    DataSet tmpResultSet;
                    String tmpStr = "";

                    tmpResultSet = myDatabaseAdapter.svcGetUserDetails(tmpUserRecID);

                    if (tmpResultSet == null || ((DataSet)tmpResultSet).Tables[0].Rows.Count == 0)
                    {
                        tmpStr = "alert('No data was found for this user...');";
                        this.Page.ClientScript.RegisterStartupScript(this.GetType(), "ex", tmpStr, true);
                    }
                    else
                    {
                        tmpDataRow = tmpResultSet.Tables[0].Rows[0];
                        txtFirstName.Text = tmpDataRow["first_name"].ToString();
                        txtLastName.Text = tmpDataRow["last_name"].ToString();
                        txtPhoneNumber.Text = tmpDataRow["phone_number"].ToString();
                        txtJob.Text = tmpDataRow["job"].ToString();
                    }
                }
            }
        }
    }
}