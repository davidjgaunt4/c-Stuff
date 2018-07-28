using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RestClient
{
    class jsonArray: jasonSimple
    {
        public List<jasonSimple> array { get; set; }
    }
}
