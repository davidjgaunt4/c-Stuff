using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RestClient
{

    //http://dry-cliffs-19849.herokuapp.com/users.json
    //[
    //{"id":2,
    //"name":"Homer Simpson",
    //"email":"homer@email.com",
    //"nationality":"United States of America"}
    //,{"id":3,"name":"Adam Smith","email":"adam@email.com","nationality":"Scottish"},{"id":4,"name":"Lemmy","email":"lemmy@email.com","nationality":"British"},{"id":5,"name":"Dame Edna Everage","email":"dameedna@email.com","nationality":"Australian"}]

    class jasonSimple
    {
        string id { get; set; }
        string name { get; set; }
        string email { get; set; }
        string nationality {get; set; } 
    }
}
