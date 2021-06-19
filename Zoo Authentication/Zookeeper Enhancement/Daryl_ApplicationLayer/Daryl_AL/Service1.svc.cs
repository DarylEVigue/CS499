using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;

namespace Daryl_AL
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Service1.svc or Service1.svc.cs at the Solution Explorer and start debugging.
    public class Service1 : IService1
    {
        String connectionString = ConfigurationManager.AppSettings["DatabaseConnectionString"];

        public string svcGetUserPassword(String argUserID, out String argUserRecID)
        {
            String tmpPassword = "";
            
            DataSet tmpDataSet = new DataSet();
            SqlConnection tmpConnection = new SqlConnection(connectionString);
            SqlCommand tmpCommand = new SqlCommand("dbo.spGetUserPassword", tmpConnection);
            tmpCommand.CommandType = CommandType.StoredProcedure;
            tmpCommand.Parameters.Add("@argUserID", SqlDbType.NVarChar, 50).Value = argUserID;
            tmpCommand.Parameters.Add("@argUserPassword", SqlDbType.NVarChar, 50).Direction = ParameterDirection.Output;
            tmpCommand.Parameters.Add("@argUserRecID", SqlDbType.NVarChar, 10).Direction = ParameterDirection.Output;

            SqlDataAdapter myDA = new SqlDataAdapter(tmpCommand);

            myDA.Fill(tmpDataSet);

            tmpPassword = tmpCommand.Parameters["@argUserPassword"].Value.ToString();
            argUserRecID = tmpCommand.Parameters["@argUserRecID"].Value.ToString();

            return tmpPassword;
        }

        public DataSet svcGetUserDetails(String argWhereClause)
        {
            DataSet tmpDataSet = new DataSet();
            SqlConnection tmpConnection = new SqlConnection(connectionString);
            SqlCommand tmpCommand = new SqlCommand("dbo.spGetUserDetails", tmpConnection);
            tmpCommand.CommandType = CommandType.StoredProcedure;
            tmpCommand.Parameters.Add("@argWhereClause", SqlDbType.NVarChar).Value = argWhereClause;
            SqlDataAdapter myDA = new SqlDataAdapter(tmpCommand);

            myDA.Fill(tmpDataSet);

            return tmpDataSet;
        }
    }
}
