import React, { useEffect, useState } from "react";
import axios from "axios";

function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [filteredPosts, setFilteredPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [userId, setUserId] = useState("all");

  const fetchPosts = () => {
    setLoading(true);
    axios
      .get("https://dummyjson.com/posts")
      .then((response) => {
        setPosts(response.data.posts);
        setFilteredPosts(response.data.posts);
        setLoading(false);
      })
      .catch((err) => {
        setError("Error fetching posts");
        setLoading(false);
      });
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  // Filter logic
  const handleFilter = (value) => {
    setUserId(value);

    if (value === "all") {
      setFilteredPosts(posts);
    } else {
      const filtered = posts.filter((post) => post.userId === parseInt(value));
      setFilteredPosts(filtered);
    }
  };

  if (loading) return <h2>Loading Posts...</h2>;
  if (error) return <h2>{error}</h2>;

  return (
    <div>
      <h2>Fake API Posts</h2>

      {/* Refresh Button */}
      <button onClick={fetchPosts}>Refresh</button>

      {/* Dropdown Filter */}
      <select value={userId} onChange={(e) => handleFilter(e.target.value)}>
        <option value="all">All Users</option>
        <option value="1">User 1</option>
        <option value="2">User 2</option>
        <option value="3">User 3</option>
      </select>

      {filteredPosts.map((post) => (
        <div key={post.id} style={{ border: "1px solid green", margin: "10px", padding: "10px" }}>
          <p><b>Title:</b> {post.title}</p>
          <p><b>Body:</b> {post.body}</p>
          <p><b>User ID:</b> {post.userId}</p>
        </div>
      ))}
    </div>
  );
}

export default FakePostList;