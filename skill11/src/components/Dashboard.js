import React from "react";
import { Link } from "react-router-dom";

function Dashboard() {
  return (
    <div style={{ textAlign: "center" }}>
      <h1>Dashboard</h1>

      <div style={{ margin: "20px" }}>
        <Link to="/local">
          <button>Local Users</button>
        </Link>
      </div>

      <div style={{ margin: "20px" }}>
        <Link to="/users">
          <button>Users API</button>
        </Link>
      </div>

      <div style={{ margin: "20px" }}>
        <Link to="/posts">
          <button>Fake API Posts</button>
        </Link>
      </div>
    </div>
  );
}

export default Dashboard;